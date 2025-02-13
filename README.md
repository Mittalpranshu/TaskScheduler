# Task Scheduler in Java

Introduction  
This project implements optimal job scheduling using two distinct approaches:  

1. Brute Force Scheduling (Exhaustive Search)  
2. Greedy Scheduling (Optimal via Ratio Heuristic)  

Given n tasks with associated weights and execution times, the objective is to minimize weighted completion time, where each task’s contribution to the overall cost is proportional to its weight.

Mathematically, given a set of jobs J = {J₁, J₂, ..., Jₙ}, each job Jᵢ has:  
A processing time pᵢ  
A weight wᵢ (priority factor)  

The goal is to find an ordering π = {π₁, π₂, ..., πₙ} that minimizes the weighted sum of completion times, defined as:  
 C_{\text{weighted}} = \sum_{i=1}^{n} w_{\pi_i} C_{\pi_i}   
where Cᵢ is the completion time of job i.



 Algorithmic Approaches
1. Brute Force Scheduling (Exhaustive Search)
This approach generates all possible permutations of job orderings.
  Each permutation’s total weighted completion time is computed.
  The permutation yielding the minimum cost is selected.
  Time Complexity:** O(n!) (Factorial growth, intractable for large n).

Why is this inefficient?
For n = 10, this results in 10! = 3,628,800 permutations—making brute-force impractical beyond n ≈ 10.



 2. Greedy Scheduling (Weighted Ratio Heuristic)
Jobs are sorted based on:  

The weight-to-length ratio heuristic ensures that higher-priority, shorter-duration jobs execute first.
The ordered jobs are processed sequentially, minimizing the total cost.
Time Complexity: O(n log n) (Efficient sorting via MergeSort/QuickSort).

Why does this work?  
It leverages Smith’s Ratio Rule, which states that sorting by wᵢ / pᵢ is optimal for minimizing weighted completion time in single-machine scheduling.



Performance Comparison  

| Approach         | Time Complexity | Execution Time (ms) | Improvement (%) |
|----------------------|----------------|---------------------|----------------|
| Brute Force          | O(n!)          | 31 ms               | 0% (Baseline)  |
| Greedy Algorithm     | O(n log n)     | 7 ms                | 77.41% Faster  |

The greedy algorithm is superior due to its polynomial complexity compared to factorial growth.



Execution Output  
 Brute Force Execution Output
(https://github.com/Mittalpranshu/TaskScheduler/blob/main/Brute.png)
      Greedy Algorithm Execution Output
(https://github.com/Mittalpranshu/TaskScheduler/blob/main/Greedy.png)
