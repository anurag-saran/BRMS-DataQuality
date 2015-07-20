[when]There is a Row with field {field} that is longer than {length}=row: Record({field}.length > {length})
[when]There is a Row with field {field} that does not match {pattern}=row: Record({field} not matches {pattern})

[then]Flag row as invalid because {message}=row.addMessage("{message}");