from rectpack import newPacker
import turtle as t
import random
import sys

#rectangles=[(50,80),(140,60),(130,30),(70,150),(100,150),(130,130),(400,400),(100,100),(20,20)]

print(len(sys.argv))

no_of_rects=int(sys.argv[1])

print (no_of_rects)

bins=[(int(sys.argv[2]),int(sys.argv[3]))]

rectangles=[]

#rectangles=[(130,60),(50,100),(70,110),(100,100),(80,90),(40,80),(80,80),(20,100)]
#bins=[(300,300)]

i=4

for i in range(4,len(sys.argv)-1,2):
    print (sys.argv[i]+" "+sys.argv[i+1])
    w=int(sys.argv[i])
    h=int(sys.argv[i+1])
    #print (str(w)+" "+str(h))
    rectangles.append([w,h])

               
packer = newPacker()

for r in rectangles:
    packer.add_rect(*r)

for b in bins:
    packer.add_bin(*b)
    

packer.pack()


all_rects = packer.rect_list()

for rect in all_rects:
    b, x, y, w, h, rid = rect 
    print(str(x)+" "+str(y)+" "+str(w)+" "+str(h)+" ")

#top=300
#bottom=0
#left=0
#right=300
    

#t.speed(3)
#t.bgcolor("white")
#t.pencolor("black")
#t.penup()
#t.goto(left,top)
#t.pendown()
#t.color("grey")
#t.begin_fill()
#for i in range(2):
    ##t.fd(300)
    #t.right(90)
   # t.fd(300)
   # t.right(90)
   # t.fd(300)
#t.end_fill()
#t.penup()

##t.color("black")
##t.goto(-120,-170)
##t.pendown()
##t.write("Driver this side",font=("Arial", 16, "normal"))
##t.penup()

#t.colormode(255)

#all_rects = packer.rect_list()
#for rect in all_rects:
    #b, x, y, w, h, rid = rect 
    #print(str(b)+" "+str(x)+" "+str(y)+" "+str(w)+" "+str(h)+" ")
    #print(str(x)+" "+str(y)+" "+str(w)+" "+str(h)+" ")
    #x1=-300+x
    #y1=top-y
    #t.color(random.randrange(255),random.randrange(255),random.randrange(255))
    #t.color("blue")
    #t.goto(x1,y1)
    #for i in range(2):
        #t.pencolor("black")
        #t.pensize(2)
        #t.begin_fill()
        #t.pendown()
        ##t.right(90)
        #t.fd(w)
        #t.right(90)
        #t.fd(h)
        #t.right(90)
    #t.end_fill()
    #t.penup()

    
    # b - Bin index
    # x - Rectangle bottom-left corner x coordinate
    # y - Rectangle bottom-left corner y coordinate
    # w - Rectangle width
    # h - Rectangle height
    # rid - User asigned rectangle id or None
    
#t.done()
