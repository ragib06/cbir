#! /usr/bin/env python

import sys
from PIL import Image

IMAGEDATABASE = '../imageDatabase/'

NUMBEROFPIXELS = 128*192
NUMBEROFIMAGES = 1000
NUMBEROFBINS = 64
SCALE = 256
NOOFDIVISION = int(round(pow(NUMBEROFBINS,1.0/3)))

def getbin(r,g,b):
	rp=r/(SCALE/NOOFDIVISION)
	gp=g/(SCALE/NOOFDIVISION)
	bp=b/(SCALE/NOOFDIVISION)
	return rp*NOOFDIVISION**2+gp*NOOFDIVISION**1+bp

fout = open('csd.csv','w')
fout.write(str(NUMBEROFIMAGES)+'\n')
fout.write(str(NUMBEROFBINS)+'\n')
for m in range(1,NUMBEROFIMAGES+1):
        print str(m)+'.jpg'
        fout.write(str(m)+'.jpg,')        

        im = Image.open(IMAGEDATABASE+str(m)+'.jpg')

        freq = [0 for i in range(NUMBEROFBINS+1)]
        
        pixels = list(im.getdata())
        width, height = im.size

        for i in range(height-4):
                for j in range(width-4):
                        Bins = []
                        for k in range(4):
                                for l in range(4):
                                        r,g,b = pixels[(i+k)*width+(j+l)]
                                        Bins.append(getbin(r,g,b))
                        Bins = list(set(Bins))
                        for k in Bins: freq[k] = freq[k]+1

        
        for i in range(NUMBEROFBINS):
                fout.write(str(freq[i]/(NUMBEROFPIXELS*1.0))+',')
        fout.write('\n')
fout.close()
print 'Done!'
