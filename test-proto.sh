#!/bin/bash

# line taken from Arknights
_dargs='silent we shall be should conflict be avoidable but fight tooth and nail should it be necessary'

# It is assumed that the project has been built.

_keys=$(./run.sh predictive.Words2SigProto <<< "$_dargs")

echo $_keys

./run.sh predictive.Sigs2WordsProto <<< "$_keys"

