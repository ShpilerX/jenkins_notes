def deadExecutors = Jenkins.instance.computers.collect { c -> 
  c.executors.findAll { !it.isActive() }
}.flatten()
deadExecutors.each { it.doYank() }
