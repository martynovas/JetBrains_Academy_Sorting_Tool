// Write your code here. Do not import any libraries
val myFile = File("MyFile.txt")
val text = myFile.readText()
myFile.writeText(text)
myFile.appendText(text)