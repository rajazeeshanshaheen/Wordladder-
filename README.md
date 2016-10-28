# Wordladder-
using java.simple i open dictonary which would b in json in my case it was AP.json
geting two words from user
then validate them in dictonary
then collect all the words from dictonary of given word length and store them in a set
sort the set
find function finds the path
it get one word difference from the given word then
push start word which is given in the function argument
and each word combination in a stack for eg[start_word,one_differnce_word],[start_word,one_differnce_word1]
then store them in a que
then it pop an elemenet
check for peek element(Stack)
and compare it with a end_word if match then return that stack
other wise it will pop stack and again call the function with this word as start_word
if it returns null
then it pop next element
in que 
and again call the function until the path is found or que is empty
