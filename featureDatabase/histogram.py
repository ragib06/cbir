#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sys
from PIL import Image

IMAGEDATABASE = '../imageDatabase/'

NUMBEROFIMAGES = 1000
NUMBEROFBINS = 64
SCALE = 256
NOOFDIVISION = int(round(pow(NUMBEROFBINS,1.0/3)))


def getbin(r,g,b):
	rp=r/(SCALE/NOOFDIVISION)
	gp=g/(SCALE/NOOFDIVISION)
	bp=b/(SCALE/NOOFDIVISION)
	return rp*NOOFDIVISION**2+gp*NOOFDIVISION**1+bp

fout = open('histogram.csv','w')
fout.write(str(NUMBEROFIMAGES)+'\n')
fout.write(str(NUMBEROFBINS)+'\n')

print 'starting...'

for m in range(1,NUMBEROFIMAGES+1):
    print str(m)+'.jpg'
    fout.write(str(m)+'.jpg,')        
    
    im = Image.open(IMAGEDATABASE+str(m)+'.jpg')

    freq = [0 for i in range(NUMBEROFBINS)]
    
    pixels = list(im.getdata())
    width, height = im.size

    for i in pixels:
		r,g,b = i
		ind = getbin(r,g,b)
		freq[ind] = freq[ind]+1
    
    for i in range(NUMBEROFBINS):
        fout.write(str(freq[i]/(width*height*1.0))+',')
    fout.write('\n')
    
    #countp=0;
    #for i in range(NUMBEROFBINS): countp=countp+freq[i]/(width*height*1.0)

fout.close()
print 'Done!'
