#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
from PIL import Image

IMAGEDATABASE = '../imageDatabase/'

NUMBEROFIMAGES = 1000
NUMBEROFPIXELS = 128*192
ACTUALBINS = 256
NUMBEROFBINS = 64
SCALE = 256
NOOFDIVISION = int(round(pow(NUMBEROFBINS,1.0/3)))
TAO = NUMBEROFPIXELS * 0.001


width = height = 0
count = 0
alpha = [0 for i in range(NUMBEROFBINS)]
beta =  [0 for i in range(NUMBEROFBINS)]
visited = [[False for i in range(width)] for j in range(height)]

#get bin number of pixel
def getbin(r,g,b):
	rp=r/(SCALE/NOOFDIVISION)
	gp=g/(SCALE/NOOFDIVISION)
	bp=b/(SCALE/NOOFDIVISION)
	return rp*NOOFDIVISION**2+gp*NOOFDIVISION**1+bp

#check if inside grid
def inBound(i,j):
	global width,height
	return i>=0 and i<height and j>=0 and j<width

#expand connected component
def concomp(r, c, grid):
	global count,visited
	count += 1
	#print 'connecting ',r,c
	for i in range(-1,2):
		for j in range(-1,2):
			if inBound(r+i,c+j) and visited[r+i][j+c]==False and grid[r+i][c+j]==grid[r][c]:
				visited[r+i][c+j] = True;
				concomp(r+i, c+j, grid)
	return count

#dfs
def dfs(grid, alpha, beta):
	global width,height,count,visited
	visited = [[False for i in range(width)] for j in range(height)]
	for i in range(height):
		for j in range(width):
			if visited[i][j] == False:
				visited[i][j] = True
				count = 0
				cc = concomp(i,j,grid)
				#print i,j,'->',count
				if count > TAO:
					alpha[grid[i][j]] += count
				else :
					#print 'updating beta ',grid[i][j]
					beta[grid[i][j]] += count
					
		#print '\n'

def getccv(image):
	pixels = list(image.getdata())
	#print len(pixels)
	global width,height,alpha,beta
	width,height = image.size
	#print image.format, width, height, image.mode

	grid = [[0 for i in range(width)] for j in range(height)]

	factor = ACTUALBINS/NUMBEROFBINS

	for i in range(height):
		for j in range(width):
			#print 'index ',i,j,i*height+j
			r,g,b = pixels[i*width+j]
			bin = getbin(r,g,b)
			grid[i][j] = bin
			#print Rplane[i][j],
		#print '\n'
        alpha = [0 for i in range(NUMBEROFBINS)]
        beta =  [0 for i in range(NUMBEROFBINS)]			
	dfs(grid, alpha, beta)	
			
def main():
	sys.setrecursionlimit(NUMBEROFPIXELS+4)
	f = open('ccv.csv','w')
	f.write(str(NUMBEROFIMAGES)+'\n')
	f.write(str(NUMBEROFBINS)+'\n')
	for k in range(1,NUMBEROFIMAGES+1):
		print k,'.jpg'
		getccv(Image.open(IMAGEDATABASE+str(k)+'.jpg'))
		f.write(str(k)+'.jpg'+',')
		for i in range(NUMBEROFBINS):
			
			a = [alpha[i],beta[i]]
			a = [ "%-15.10f" % (a[i]/(NUMBEROFPIXELS*1.0)) for i in range(len(a))]
			f.write(' '.join(a)+',')
		f.write('\n')
	f.close()
	print 'Done!'
	return 0

if __name__ == '__main__':
	main()
	
