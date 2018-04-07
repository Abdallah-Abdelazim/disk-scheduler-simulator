# Disk-Scheduler-Simulator
A scheduling simulator that implements different disk scheduling algorithms and applies it on a disk queue with requests for I/O blocks on cylinders.  
Program created in Java. GUI is created using Javafx.  

This Program compares the output after applying different disk scheduling algorithms
i.e. FCFS, SSTF, SCAN ,C-SCAN, Look, C-Look by implementing their algorithms and apply it on a disk queue with requests for I/O blocks
on cylinders.  

**Input:**
* cylinders I/O requests. e.g. *98, 183, 37, 122, 14, 124, 65, 67*
* Initial head start cylinder: e.g. *53*


**Output**
For each algorithm: the sequence of head movement to access the requested
cylinders based on the implemented algorithms.  

---
The following rules are followed:  
1. The Input queue like above should be an input to your program from a file or through GUI.
2. The Initial head start cylinder should also be an input to your program and entered by
the user as Input from a file or through GUI.
3. The output result should show the sequence of head movement to access the requested
cylinders based on the implemented algorithms.
4. Show the sequence result at the end as separate rows for applying the different
algorithms on the same input data and show the total head movement per algorithm.

![GIF Demo](http://i.imgur.com/y65ApEo.gif)

