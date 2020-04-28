# The dining philosophers solution in java

The dining philosophers problem states that there are 5 philosophers sharing a circular table and they eat and think alternatively. There is a bowl of rice for each of the philosophers and 5 forks. A philosopher needs both their right and a left forks to eat. A hungry philosopher may only eat if there are both forks available. Otherwise, a philosopher puts down their forks and begin thinking again.

There are two implementations of philosophers. One using standard synchronization mechanism and second using java.util.concurrent.locks package ReentrantLock classes. It demonstrates that standard synchronization implementation can make deadlock and concurrent package locks helps you to avoid deadlock and are very simple to use.

