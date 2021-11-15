#!/bin/bash

[ -d bin ] || mkdir bin

pwd
which javac && javac -d bin -sourcepath src src/**/*.java

