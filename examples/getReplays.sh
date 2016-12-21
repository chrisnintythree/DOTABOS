#!/bin/bash
for filename in test/*; do
		grep cluster $filename >> clusters.txt 
		grep replay_salt $filename >> salts.txt
done
ls test/ >> ids.txt
rm -r test/*
grep -Eo '[0-9]{1,}' clusters.txt > clusters_only.txt
grep -Eo '[0-9]{1,}' salts.txt > salts_only.txt
grep -Eo '[0-9]{1,}' ids.txt > ids_only.txt
rm ids.txt
rm clusters.txt
rm salts.txt
echo "Getting Repalys"
file1="clusters_only.txt"
file2="salts_only.txt"
file3="ids_only.txt"
while true
do
	read -r f1 <&3 || break
	read -r f2 <&4 || break
	read -r f3 <&5 || break
	curl --get "http://replay${f1}.valve.net/570/${f3}_${f2}.dem.bz2" > replays/$f3.dem.bz2
done 3<$file1 4<$file2 5<$file3
rm clusters_only.txt
rm salts_only.txt
rm ids_only.txt
