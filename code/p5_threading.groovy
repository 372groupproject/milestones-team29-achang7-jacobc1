// This an example for threading in groovy. It would run the 
// the new thread and proceed to the old thread after finished with
// hte new thread

// This example prints out as follows:
// new thread
// old thread

def thread = Thread.start {
  sleep(2000)
  println "new thread"
}

// The join function waits for the previous thread to be finished before 
// proceeding with current task.
thread.join()
println "old thread"


// This example prints out as follows:
// old thread
// new thread

def thread = Thread.start {
  sleep(2000)
  println "new thread"
}

println "old thread"