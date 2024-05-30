#code 29/5/2024

import RPi.GPIO as GPIO
import sqlite3
from datetime import datetime
import datetime
from ultralytics import YOLO
import cv2
import serial
import time
import sys
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtCore import QTimer, Qt, QRect
from PyQt5.QtWidgets import QFrame, QMainWindow, QFileDialog, QStyledItemDelegate, QMessageBox
from PyQt5.QtGui import QPixmap

SERIAL_PORT = '/dev/ttyACM0'  # Check which port your Arduino is connected to
SERIAL_RATE = 9600

RELAY_PIN = 16  # GPIO pin connected to the relay control pin
# BUTTON_PIN = 12
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(RELAY_PIN, GPIO.OUT)
# GPIO.setup(BUTTON_PIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)

class SerialTerminalApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Face Recognition App")
        self.showFullScreen()  # Set the window to full screen mode
        self.setWindowFlags(Qt.FramelessWindowHint)
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.ui.lbl_detect.installEventFilter(self)
        # self.ui.graphicsView.installEventFilter(self)
        self.ui.lbl_RFID.installEventFilter(self)
        self.count = 0
        
        self.timer = QtCore.QTimer(self)
        self.timer.timeout.connect(self.updateDateTime)
        self.timer.start(1000)  # Cáº­p nháº­t má»—i giÃ¢y
        
    
    def updateDateTime(self):
        now = datetime.datetime.now()
        self.ui.dt_look.setDateTime(now)
 
    def eventFilter(self, obj, event):
        if obj == self.ui.lbl_detect:
            if event.type() == QtCore.QEvent.MouseButtonPress:
                mouseEvent = event
                if mouseEvent.button() == QtCore.Qt.LeftButton:
                    self.ui.detection()
                    return True
        elif obj == self.ui.lbl_RFID:
            if event.type() == QtCore.QEvent.MouseButtonPress:
                mouseEvent = event
                if mouseEvent.button() == QtCore.Qt.LeftButton:
                    #print("Xin má»i quÃ©t tháº»")
#                     msg = QMessageBox()
#                     msg.setWindowTitle("ThÃ´ng bÃ¡o")
#                     msg.setText("Xin moi quet the.")
#                     msg.exec_()
#                     # Tá»± Ä‘á»™ng Ä‘Ã³ng thÃ´ng bÃ¡o sau 2 giÃ¢y
#                     QTimer.singleShot(2000, lambda: closeMessageBox(msg))
                    self.ui.rfid()
                    return True
        return super().eventFilter(obj, event)
    def keyPressEvent(self, event):
        if event.key() == QtCore.Qt.Key_Escape:
            self.close()  # Close the application when Esc is pressed
        super().keyPressEvent(event) 

# HÃ m Ä‘á»ƒ má»Ÿ cá»­a
def unlock_door(user_id):
    
    GPIO.output(RELAY_PIN, GPIO.HIGH)  # Activate the relay
    save_unlock_time(user_id)
    time.sleep(10)  # Má»Ÿ cá»­a trong 5 giÃ¢y
    GPIO.output(RELAY_PIN, GPIO.LOW)  # Deactivate the relay

def unlock_door_button():
    GPIO.output(RELAY_PIN, GPIO.HIGH)
    time.sleep(10)
    GPIO.output(RELAY_PIN, GPIO.LOW)

# def button_callback(channel):
#     print("Nút đã được nhấn! Thực hiện chức năng của bạn ở đây.")
#     unlock_door_button()
#     # Cấu hình sự kiện ngắt cho nút bấm
#     GPIO.add_event_detect(BUTTON_PIN, GPIO.FALLING, callback=button_callback, bouncetime=300)
#     time.sleep(10)
# try:
#     while True:
#         time.sleep(1)  # Chương trình chính chạy liên tục và chờ sự kiện
# except KeyboardInterrupt:
#     print("Thoát chương trình")
# finally:
#     GPIO.cleanup() 
    
def save_unlock_time(user_id):
    conn = sqlite3.connect('detection_data.db')
    c = conn.cursor()
    current_time = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    c.execute("INSERT INTO QLLS (UserID, TimeIn) VALUES (?, ?)", (user_id, current_time))
    conn.commit()
    conn.close()
    print(f"LÆ°u thá»i gian má»Ÿ khÃ³a: UserID = {user_id}, TimeIn = {current_time}")

# HÃ m Ä‘á»ƒ truy xuáº¥t tÃªn chá»§ sá»Ÿ há»¯u tá»« cÆ¡ sá»Ÿ dá»¯ liá»‡u
def get_owner_name(card_id):
    conn = sqlite3.connect('detection_data.db')
    c = conn.cursor()
    c.execute("""Select QLMembers.UserName from QLThe  join QLMembers on QLThe.UserID = QLMembers.UserID where QLThe.TheUID = ?""", (card_id,))
    row = c.fetchone()
    conn.close()
    if row:
        return row[0]
    else:
        return "Unknown"

# HÃ m Ä‘á»ƒ láº¥y UserID tá»« tÃªn ngÆ°á»i dÃ¹ng
def get_user_id(user_name):
    conn = sqlite3.connect('detection_data.db')
    c = conn.cursor()
    c.execute("""SELECT UserID 
                 FROM QLMembers 
                 WHERE UserName = ?""", (user_name,))
    row = c.fetchone()
    conn.close()
    if row:
        return row[0]
    else:
        return None

def face_recognition():
    # Load model YOLO
    model = YOLO('/home/tuan/tuan/face/best2.pt')
    cap = cv2.VideoCapture(0)
    cap.set(3, 640)
    cap.set(4, 480)
    window_name = 'Face Detection'
    cv2.namedWindow(window_name, cv2.WINDOW_NORMAL)
    while True:
        ret, img = cap.read()
        if not ret:
            break
        results = model.predict(img)
        # LÆ°u tÃªn nhÃ£n vÃ  thá»i gian vÃ o cÆ¡ sá»Ÿ dá»¯ liá»‡u
        for r in results: 
            boxes = r.boxes
            for box in boxes:
                c = box.cls
                uName = model.names[int(c)]
                print(uName)
                user_id = get_user_id(uName)
                if user_id:
                    confidence = box.conf[0] # Láº¥y Ä‘á»™ chÃ­nh xÃ¡c cá»§a viá»‡c nháº­n diá»‡n
                    if (confidence > 0.8):
                        print(f"Nháº­n diá»‡n: {uName} vá»›i Ä‘á»™ chÃ­nh xÃ¡c: {confidence}")
                        unlock_door(user_id)
                        cap.release()  # Táº¯t camera
                        cv2.destroyWindow(window_name)  # ÄÃ³ng táº¥t cáº£ cá»­a sá»• OpenCV 
                        return
                    else:
                        print("Face is cph")
                        #msg = QMessageBox()
                        #msg.setWindowTitle("ThÃ´ng bÃ¡o")
                        #msg.setText("hÃ£y nhÃ¬n vÃ o camera")
                        #msg.exec_()  # Hiá»ƒn thá»‹ thÃ´ng bÃ¡o vÃ  chá» ngÆ°á»i dÃ¹ng Ä‘Ã³ng láº¡i
                        # def close_msg_box():
                        #     msg.close()
                        # QTimer.singleShot(2000, close_msg_box)
                else:
                    #print("NgÆ°á»i dÃ¹ng khÃ´ng tá»“n táº¡i trong cÆ¡ sá»Ÿ dá»¯ liá»‡u.")
                    msg = QMessageBox()
                    msg.setWindowTitle("ThÃ´ng bÃ¡o")
                    msg.setText("NgÆ°á»i dÃ¹ng khÃ´ng tá»“n táº¡i trong cÆ¡ sá»Ÿ dá»¯ liá»‡u.")
                    msg.exec_()  # Hiá»ƒn thá»‹ thÃ´ng bÃ¡o vÃ  chá» ngÆ°á»i dÃ¹ng Ä‘Ã³ng láº¡i
                    def close_msg_box():
                            msg.close()
                    QTimer.singleShot(2000, close_msg_box)

        cv2.imshow(window_name, img)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    cap.release()
    cv2.destroyWindow(window_name)

def arduino_rfid():
    try:
        # Open serial connection
        ser = serial.Serial(SERIAL_PORT, SERIAL_RATE, timeout=1)
        # Main loop
        while True:
            # Read data from Arduino
            data = ser.readline().decode().strip()
            if data:
                card_id = data
                print("Card:", card_id)
                if card_id:
                    # unlock_door()
                    owner_name = get_owner_name(card_id)
                    print("chu the la:", owner_name)
                    # Má»Ÿ cá»­a náº¿u tÃ¬m tháº¥y chá»§ sá»Ÿ há»¯u
                    user_id = get_user_id(owner_name)
                    if user_id:
                        unlock_door(user_id)
                    else:
                        print(" quet the")
                    # print("NgÆ°á»i dÃ¹ng khÃ´ng tá»“n táº¡i trong cÆ¡ sá»Ÿ dá»¯ liá»‡u.")
                else:
                    print("Khong phat hien the RFID.")
            time.sleep(0.1)
    except KeyboardInterrupt:
        print("Exiting program")
    except Exception as e:
        print("Error:", e)
    finally:
        # Close serial connection
        if ser.is_open:
            ser.close()        

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.setEnabled(False)
        MainWindow.resize(480, 320)
        
        # Táº¡o QGraphicsView vÃ  QGraphicsScene Ä‘á»ƒ hiá»ƒn thá»‹ background
        self.background_view = QtWidgets.QGraphicsView(MainWindow)
        self.background_view.setGeometry(QtCore.QRect(0, 0, 480, 320))
        self.background_scene = QtWidgets.QGraphicsScene()
        self.background_view.setScene(self.background_scene)
        
        # ThÃªm background vÃ o QGraphicsScene
        pixmap_bg = QtGui.QPixmap("/home/tuan/tuan/face/image/bg.jpg")
        self.background_scene.addPixmap(pixmap_bg)
        
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.dt_look = QtWidgets.QDateTimeEdit(self.centralwidget)
        self.dt_look.setEnabled(False)
        self.dt_look.setGeometry(QtCore.QRect(130, 20, 201, 20))
        font = QtGui.QFont()
        font.setPointSize(11)
        self.dt_look.setFont(font)
        self.dt_look.setObjectName("dt_look")
        self.lbl_detect = QtWidgets.QLabel(self.centralwidget)
        self.lbl_detect.setGeometry(QtCore.QRect(40, 80, 141, 131))
        self.lbl_detect.setFrameShape(QtWidgets.QFrame.Box)
        self.lbl_detect.setLineWidth(2)
        self.lbl_detect.setText("")
        pixmap_detect = QPixmap("/home/tuan/tuan/face/image/button1.png")  # ÄÆ°á»ng dáº«n Ä‘áº¿n file áº£nh cá»§a báº¡n
        self.lbl_detect.setPixmap(pixmap_detect)
        self.lbl_detect.setScaledContents(True)
        self.lbl_detect.setObjectName("lbl_detect")
        self.lbl_RFID = QtWidgets.QLabel(self.centralwidget)
        self.lbl_RFID.setGeometry(QtCore.QRect(260, 80, 141, 131))
        self.lbl_RFID.setFrameShape(QtWidgets.QFrame.Box)
        self.lbl_RFID.setLineWidth(2)
        self.lbl_RFID.setText("")
        pixmap_rfid = QPixmap("/home/tuan/tuan/face/image/button2.png")  # ÄÆ°á»ng dáº«n Ä‘áº¿n file áº£nh cá»§a báº¡n
        self.lbl_RFID.setPixmap(pixmap_rfid)
        self.lbl_RFID.setScaledContents(True)
        self.lbl_RFID.setObjectName("lbl_RFID")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 480, 26))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))

    def detection(self):
        face_recognition()
    
    def rfid(seft):
        arduino_rfid()
        
if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = SerialTerminalApp()
    MainWindow.show()
    
#     face_thread = QtCore.QThread()
#     face_thread.started.connect(face_recognition)
#     face_thread.start()
    
    sys.exit(app.exec_())
    
