#!/bin/bash    
# Source env variable
source ./export.bash
_now=$(date "+%Y.%m.%d-%H.%M.%S")
echo "Getting Repalys"
curl --get --include 'https://community-dota-2.p.mashape.com/IDOTA2Match_570/GetMatchHistory/V001/?key=A15BA1CAED87271BB1B6567D7D493227&format=JSON' \
  -H 'X-Mashape-Key: ec0cMQEccYmshipwX7cJzJbAWUoup1OusvYjsnsoW9d8YpNugb' \
  -H 'Accept: application/json' > test/matchList.txt
grep match_id test/matchList.txt > test/match_ids.txt
grep -Eo '[0-9]{1,}' test/match_ids.txt > test/match_ids_only.txt
rm test/match_ids.txt
filename="test/match_ids_only.txt"
while read -r line
do
    export VAR=$line
    echo $VAR
#curl --get --include "https://community-dota-2.p.mashape.com/IDOTA2Match_570/GetMatchDetails/V001/?#key=A15BA1CAED87271BB1B6567D7D493227&match_id=${VAR}&matches_requested=<required>" \
#  -H 'X-Mashape-Key: ec0cMQEccYmshipwX7cJzJbAWUoup1OusvYjsnsoW9d8YpNugb' \
#  -H 'Accept: application/json' > test/matchDetails_$VAR.txt

  #gnome-terminal --window-with-profile=noclose -e 
  ./getMatchDetails.sh $VAR
  sleep 10

done < "$filename"
./getReplays.sh
./parse.sh

