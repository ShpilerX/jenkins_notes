# Restart all dead executros on Jenkins (use from Script Console)
def deadExecutors = Jenkins.instance.computers.collect { c ->
  c.executors.findAll { !it.isActive() }
}.flatten()
deadExecutors.each { it.doYank() }
