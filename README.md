# invaders
Detect Invaders Pattern in a given input image.

Uses Java8

Invaders is a command line project. 

It takes as input: 
	-The name of a 'txt' file with the radar image input
	-An optional value with the desired detection accuracy
And returns t the standr output the amount of invaders found in the input.

For simplicity in this prototype I assumed that:
- All the input files are located in the resources/input folder (inside the project).

- The entries in the input files are always well formed:
	- Proper matrix size
	- Only contains values: either 'o' or '-'
	- If treshold is given it is an integer

The two given invader patterns are pre loaded in the resources file in the project (more could be added in the resources/invaders folder)


Future work ideas:
	- Improve recognition when overlap: Right now if there is an overlap of invaders they are counted.
	- Add better validation and control of input (params and file)
	- Read input from absolute paths
	- Improve performance
	- Extract texts of main to resources file
	- Testing
		- Mock input in 'DetectInvadersTest' to avoid dependecy with 'Parser.java'
		- More test coverage
		- Integration tests
