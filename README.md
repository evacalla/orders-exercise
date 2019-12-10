# Orders | Exercise


En la tabla de Orders de podira implementar indices para mejor el acceso a los datos, en la cache se podría implementar 
Redis que permite implementar replicación y particionenes, el caso de replicación 
redis provee una replicación tipo master-slave, que permite hacer copias exactas del maestro
una de sus características principales es que una replicación asincrónica, y como es tipo master-slave 
no es una replicación bloqueante ni del master o slave o a si mismo ,slave mientras se esta sincronizando, 
puede responder consultas, en el caso de particionamiento permite mejor distribución de la carga, que los datos se
distribuyen de forma que la carga de los nodos sea pareja, eso facilidad mejor el acceso a los datos.
