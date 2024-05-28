import RPi.GPIO as GPIO
import spidev
from mfrc522 import MFRC522

class MFRC522_SPI1:
    NRSTPD = 22

    def __init__(self):
        self.spi = spidev.SpiDev()
        self.spi.open(1, 0)
        self.spi.max_speed_hz = 1000000
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(self.NRSTPD, GPIO.OUT)
        GPIO.output(self.NRSTPD, 1)

    def _spi_transfer(self, data):
        return self.spi.xfer2(data)

    def MFRC522_Reset(self):
        GPIO.output(self.NRSTPD, 0)
        GPIO.output(self.NRSTPD, 1)

    # Các hàm khác của MFRC522 bạn cần thêm ở đây

# Sử dụng lớp MFRC522_SPI1 để giao tiếp với RFID
reader = MFRC522_SPI1()

try:
    print("Đặt thẻ của bạn gần đầu đọc")
    id, text = reader.read()
    print("ID: %s\nText: %s" % (id, text))
finally:
    GPIO.cleanup()
