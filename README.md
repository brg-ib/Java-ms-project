# Blog micro service


### arborescence du projet

```
Java-ms-project
│   README.md    
│
└─── BDD
│   │   delta_blog.sql -> Base de donnée du blog
│   
└─── Categorie -> Miscro-service categorie
|
└─── Commentaire -> Miscro-service Commentaire
|
└─── User -> Miscro-service User
|
└─── eureka_server -> Miscro-service eureka
|
└─── gateway -> Miscro-service Passerelle
|
└─── Article -> Miscro-service Article
|
└─── Client -> Miscro-service Client

```
----

**Micro services**
- Eureka : Port 9102
- Gateway : Port 9003
- User : Port 9010
- Commentaire : Port 9030
- Categorie : Port 9020
- Article : Port 9040
- Client : Port 9050
----

**Services utilisés**
- Répartition charge : Ribbon
- Découvrabilité : Eureka
- Passerelle : Gateway
----

***About***           
1. Ihcen Borgi
2. Awa Diop
