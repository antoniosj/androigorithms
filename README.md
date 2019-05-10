# androigorithms

This was a challenge that I did to my position as an Embedded Android Engineer.

-x Portuguese x- 

Para testar as questões de algoritmos, basta rodar os testes unitários.

Para testar o app 1, basta dar launch nele.

Para testar o app 2, caso não esteja configurado, é preciso definir que o app não vai dar launch em activity default. Ele deve executar apenas o serviço (Run > Edit Configuration > Launch - None).

A seguir estão os links e algumas explicações pra o que fiz:

### Question 1:
Complexity time: O(N) and space: O(1)

Link: [Question 1](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/main/java/com/antoniosj/strings/arraysandstrings/ReplaceCharacters.java)
Link 2: [Question 1 - Testes](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/test/java/com/antoniosj/strings/arraysandstrings/ReplaceCharactersUnitTest.java)

### Question 2:
Complexity time: O(N) and extra space: O(1)

Link: [Question 2](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/main/java/com/antoniosj/strings/arraysandstrings/CheckWords.java)
Link 2: [Question 2 - Testes](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/test/java/com/antoniosj/strings/arraysandstrings/CheckWordsUnitTest.java)

### Question 3:
Complexity time and space: O(N)

Link: [Question 3](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/main/java/com/antoniosj/strings/arraysandstrings/CheckTypos.java)
Link 2: [Question 3 - Testes](https://github.com/antoniosj/androigorithms/blob/master/Strings/app/src/test/java/com/antoniosj/strings/arraysandstrings/CheckTyposUnitTest.java)

### Question 4:
Android app 1

Para dar refresh na lista é só dar swipe (como no twitter/fb/etc) pra baixo.

Link: [App String](https://github.com/antoniosj/androigorithms/tree/master/Strings)

### Question 5:
Complexity time: O(N) and space: O(1)

Link: [Question 5](https://github.com/antoniosj/androigorithms/blob/master/Linked/app/src/main/java/com/antoniosj/linked/linkedlists/EmailThread.java)

Link 2: [Question 5 - Testes](https://github.com/antoniosj/androigorithms/blob/master/Linked/app/src/test/java/com/antoniosj/linked/EmailThreadUnitTest.java)

### Question 6:
Android app 2 (service)

Para a cláusula do queue de emails, eu utilizei Messenger. o Messenger já faz o enqueue das threads. IntentService ou Broadcast com 1 thread no onCommandStart resolveria também esse problema, porém o Messenger faz a comunicação 2 way de uma forma bem legal.

Link: [App Linked](https://github.com/antoniosj/androigorithms/blob/master/Linked)

### Question 7:
Complexity time: O(M+N) and extra space: O(1)

Link: [Question 7](https://github.com/antoniosj/androigorithms/blob/master/Linked/app/src/main/java/com/antoniosj/linked/linkedlists/EmailIntersection.java)

Link 2: [Question 7 - Testes](https://github.com/antoniosj/androigorithms/blob/master/Linked/app/src/test/java/com/antoniosj/linked/EmailIntersectionUnitTest.java)

