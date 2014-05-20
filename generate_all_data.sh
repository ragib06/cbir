#!/bin/bash

cd featureDatabase
echo 'feature: **Histogram**'
python ./histogram.py
echo 'feature: **Color Structure Descriptor**'
python ./csd.py
echo 'feature: **Color Coherence Vector**'
python ./ccv.py
cd ..
