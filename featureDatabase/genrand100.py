#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import random

fout = open('rand100.csv','w')
for i in range(10):
		for j in range(10):
				n = random.randrange(100*i,100*i+99)+1
				print n
				fout.write(str(n)+'.jpg,')
