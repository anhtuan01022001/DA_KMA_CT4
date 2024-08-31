# Raspberry pi 4B:

> Set-up: 
> 1. Install Raspbian OS on Raspberry Pi 4B.
> 2. update, upgrade
> 3. Terminal code:
>> - sudo apt-get update
>> - sudo apt-get upgrade
>> - sudo pip3 install -U pip
>> - sudo pip3 insatll opencv-python
>> - python -m pip install --index-url=https://pypi.org/simple/ --trusted-host=pypi.org --upgrade pip
>> - pip3 install torch torchvision torchaudio
>> - git clone https://github.com/Ultralytics/yolov5.git
>> - pip install -U pip
>> - cd ~/yolov5
>> - pip3 install -r requirements.txt

# Laptop(Server, PC)

>  1. set-up lib for windows
> -  pip install -r requirements.txt
>  2. add code for Arduino Uno R3
> -  file code: code-arduino.ino

# Run code

## Run code in terminal Server and client Raspberry

> 1. python server.py
> 2. python3 client-pi.py

## Run code in terminal pc

> python client-desktop.py
