***The program is written in Java***

**Program Description**

The program will take in a list of orders for theater seats. It will assign the seat for each order according to: 1. Maximize the seat capacity 2. Customer satisfaction. After finishing the assignment, the program will generate an output file with all the assignments. 


**Execution steps: 

1. Open command line and iterate through ~/theaterSeats/src
2. Type "javac Main.java" to compile the program
3. Type "java Main [file_path]” to execute the program, For example: java Main InputFiles/input.txt
4. The program will indicate the path of the output file 

**Assumptions of the program: 

1. The customers of the same order always want to sit in the same row to maintain their satisfaction. 
2. Preferable row starts from F -> J, then D, C, B, A. 
3. The preference will be the same for the seats on the same row. 
4. There is no single order is more than 20 people. I assume the order more than 20 is considered a group order and it should be taken care differently. 
5. The input line should not have empty space in the end. 
6. If the seats can't be on the same row or there is not enough seats for the order, the program will show "No Available Seats" for the reservation. 
