import time
import random
from collections import deque

class Job:
    """A class to represent a job with a name and processing time."""
    def __init__(self, name, total_epochs):
        self.name = name
        self.total_epochs = total_epochs
        self.epochs_left = total_epochs

    def __repr__(self):
        return f"Job({self.name}, Epochs Left: {self.epochs_left}/{self.total_epochs})"

def simulate_epoch(job_name):
    """Simulates the time taken for one training epoch."""
    duration = random.uniform(0.5, 1.5) # Random duration between 0.5 and 1.5 seconds
    print(f"    -> Training '{job_name}' for one epoch... (lasts {duration:.2f}s)")
    time.sleep(duration)
    print(f"    -> Epoch for '{job_name}' complete.")

def fcfs_scheduler(jobs):
    """
    Simulates the First-Come, First-Served (FCFS) scheduling algorithm.
    """
    print("\n--- Starting FCFS Scheduler Simulation ---")
    job_queue = deque(jobs)
    
    while job_queue:
        current_job = job_queue.popleft()
        print(f"\n[FCFS] Picking up job: {current_job.name}. It needs {current_job.epochs_left} epochs.")
        
        while current_job.epochs_left > 0:
            simulate_epoch(current_job.name)
            current_job.epochs_left -= 1
            
        print(f"[FCFS] Job '{current_job.name}' has finished training.")
    
    print("\n--- FCFS Simulation Complete: All jobs processed. ---")

def round_robin_scheduler(jobs, time_quantum):
    """
    Simulates the Round Robin (RR) scheduling algorithm.
    """
    print(f"\n--- Starting Round Robin Scheduler Simulation (Time Quantum: {time_quantum} epochs) ---")
    job_queue = deque(jobs)
    
    while job_queue:
        current_job = job_queue.popleft()
        print(f"\n[RR] Switching to job: {current_job.name}. It has {current_job.epochs_left} epochs left.")
        
        epochs_to_run = min(current_job.epochs_left, time_quantum)
        
        print(f"       Will run for {epochs_to_run} epochs (or until completion).")
        
        for _ in range(epochs_to_run):
            simulate_epoch(current_job.name)
            current_job.epochs_left -= 1
            
        if current_job.epochs_left > 0:
            print(f"       Time quantum finished for '{current_job.name}'. Placing back in queue.")
            job_queue.append(current_job)
        else:
            print(f"[RR] Job '{current_job.name}' has finished training.")
            
    print("\n--- Round Robin Simulation Complete: All jobs processed. ---")


if __name__ == "__main__":
    # Define a list of SLM training jobs with a random number of epochs
    job_list = [
        Job("Small Language Model A", random.randint(3, 5)),
        Job("Medium Language Model B", random.randint(4, 6)),
        Job("Small Language Model C", random.randint(2, 4)),
        Job("Large Language Model D", random.randint(5, 7))
    ]

    print("Job Queue for today:")
    for j in job_list:
        print(f"- {j.name} requiring {j.total_epochs} epochs.")

    # Run FCFS Simulation
    # We need to create fresh copies of jobs as the objects are modified by the schedulers
    fcfs_jobs = [Job(j.name, j.total_epochs) for j in job_list]
    fcfs_scheduler(fcfs_jobs)
    
    print("\n" + "="*50 + "\n")
    
    # Run Round Robin Simulation
    rr_jobs = [Job(j.name, j.total_epochs) for j in job_list]
    time_quantum = 2 # Each job runs for 2 epochs before being moved to the back of the queue
    round_robin_scheduler(rr_jobs, time_quantum)
