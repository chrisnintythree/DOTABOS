#!/bin/bash
for filename in replays/*; do
	bzip2 -ckd $filename > demFiles/"$(basename ${filename%%.*})".dem
done
for filename in demFiles/*; do 
	java -jar combatlog.one-jar.jar $filename > combatlog.txt
	filename=$(basename $filename)
	java -jar Untitled.jar >> Parsed/parsed_"${filename%%.*}".txt
	cp combatlog.txt CombatLogs/CombatLog_"${filename%%.*}".txt
done
rm -r replays/*
