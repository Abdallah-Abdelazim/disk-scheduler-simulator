# Disk-Scheduler-Simulator
A schudling simulator that implements different disk scheduling algorithms and applies it on a disk queue with requests for I/O blocks on cylinders.
Program created in Java. GUI is created using Javafx.

This Program compares the output after applying different disk scheduling algorithms
i.e. FCFS, SSTF, SCAN ,C-SCAN, Look, C-Look by implementing their algorithms and apply it on a disk queue with requests for I/O blocks
on cylinders.

<b>Input:</b> 
cylinders I/O requests.
e.g. <b>98, 183, 37, 122, 14, 124, 65, 67</b>
<br>Initial head start cylinder: e.g. <b>53</b>

<b>Output</b>
<i>For each algorithm:</i> the sequence of head movement to access the requested
cylinders based on the implemented algorithms

The following information are followed:
1- The Input queue like above should be an input to your program from a file or through GUI.<br>
2- The Initial head start cylinder should also be an input to your program and entered by
the user as Input from a file or through GUI.<br>
3- The output result should show the sequence of head movement to access the requested
cylinders based on the implemented algorithms.<br>
4- Show the sequence result at the end as separate rows for applying the different
algorithms on the same input data and show the total head movement per algorithm<br>

![GIF Demo](http://i.imgur.com/kn5DfDW.gif)

