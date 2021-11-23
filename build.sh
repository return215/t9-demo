#!/bin/bash

[ -d bin ] || mkdir bin

which javac > /dev/null && javac -d bin -sourcepath src src/**/*.java

