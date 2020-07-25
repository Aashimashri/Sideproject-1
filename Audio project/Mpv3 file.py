import os
from tkinter.filedialog import askdirectory

import  pygame
from mutagen.id3 import ID3
from tkinter import *

root = Tk()
root.minsize(300,300)

listofsongs = []
realnames = []

v= StringVar()
songlabel = Label(root,textvariable = v,width = 35)



index = 0

def playsong(event):
    pygame.mixer.music.load(listofsongs[index])
    pygame.mixer.music.play()
    updatelabel()

def updatelabel():
    global index
    global songname
    v.set(realnames[index])
    # return songname

def nextsong(event):
    global index
    index += 1
    pygame.mixer.music.load(listofsongs[index])
    pygame.mixer.music.play()
    updatelabel()

def prevsong(event):
    global index
    index -= 1
    pygame.mixer.music.load(listofsongs[index])
    pygame.mixer.music.play()
    updatelabel()

def stopsong(event):
    pygame.mixer.music.stop()
    v.set(" ")




def directoychooser():
    directoy = askdirectory()
    os.chdir(directoy)

    for files in os.listdir(directoy):
        if files.endswith(".mp3"):
            realdir = os.path.realpath(files)
            audio = ID3(realdir)
            realnames.append(audio['TIT2'].text[0])

            listofsongs.append(files)


    pygame.mixer.init()
    pygame.mixer.music.load(listofsongs[0])
    pygame.mixer.music.play()

directoychooser()


label = Label(root,text =" Media player")
label.pack()

listbox = Listbox(root)
listbox.pack()

realnames.reverse()

for items in realnames:
    listbox.insert(0,items)

realnames.reverse()


playbtn = Button(root,text = "Play button ")
playbtn.pack()

nextbtn = Button(root,text = "Next button")
nextbtn.pack()



previousbtn = Button(root,text = "previous button")
previousbtn.pack()

stopbutton = Button(root,text = "stop button")
stopbutton.pack()

playbtn.bind("<Button-1>",playsong)
nextbtn.bind("<Button-1>",nextsong)
previousbtn.bind("<Button-1>",prevsong)
stopbutton.bind("<Button-1>",stopsong)

songlabel.pack()




root.mainloop()
