import os
from flask import Flask
app = Flask(__name__)

@app.route("/")
def hello():
    print("hello")
    return "Karndiss Srien!"
# @app.route("/speaker/turn/")
# def param():
#     x = input('turn: ' )
#     if x == 'off':
#         print('off')
#         pass
#     elif x == 'on':
#         print('on')
#         os.system("omxplayer -o hdmi song.mp3")
#     else:
#         pass
@app.route("/speaker/turn/on/")
def turnon():
#   os.system("cd ~/Desktop/theMagicalBox/")
    os.system("omxplayer -o local /home/pi/Desktop/song.mp3 &")
    return "turn on"
@app.route("/speaker/turn/off/")
def turnoff():
    os.system("pkill omxplayer")
    return "turn off"

if __name__ == "__main__":
    app.run(host='0.0.0.0',port=40000)