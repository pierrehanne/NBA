# NBA App 

Projet d'application Android réalisée sur le thème de la NBA.

Cette application utilise une APIRest de : https://www.balldontlie.io/#introduction
<br/>

### Pré-requis

- Installer Android Studio </br>
- Ouvrir le projet sur Android Studio </br>
```
git clone https://github.com/pierrehanne/NBA.git
```
### Architecture MVC

![alt text](https://upload.wikimedia.org/wikipedia/commons/6/63/ModeleMVC.png)</br>
<u>Image Source : https://upload.wikimedia.org/wikipedia/commons/6/63/ModeleMVC.png</u>

### Utilisations technique

Java,Retrofit

### Résumé

- Architecture MVC </br>
- Animation d'accueil, SplashScreen </br>
- Menu avec 3 choix (équipes NBA, Logos NBA, vidéos Youtubes NBA) </br>
- Utilisation de ListView pour l'équipe NBA et d'une GridView pour les logos NBA </br>
- Utilisation de RecyclerView </br>
- Listes de vidéos provenant de Youtube </br>
- Appel à un webService - APIRest avec Retrofit </br>
- Stockage des données dans le cache avec SharedPreferences </br>
- Gitflow </br>

### Captures d'écrans

#### SplashScreen & Menu
![screen01](https://user-images.githubusercontent.com/43729077/54877680-f1418100-4e21-11e9-9bb6-3f7a5e01cb13.jpg)
![Screen02](https://user-images.githubusercontent.com/43729077/54877691-074f4180-4e22-11e9-9033-e6e02ff866cc.jpg) </br>

#### RecyclerView des équipes
![Screen03](https://user-images.githubusercontent.com/43729077/54877697-12a26d00-4e22-11e9-9720-e3bee90af9b7.jpg)

#### CardView des logos d'équipes
![Screen04](https://user-images.githubusercontent.com/43729077/54877706-1d5d0200-4e22-11e9-8515-99eccde9704e.jpg)

#### RecyclerView de vidéos Youtube
![Screen05](https://user-images.githubusercontent.com/43729077/54877709-2a79f100-4e22-11e9-9209-e1f7841407bb.jpg)

### <b><i>Bonus (pour ceux qui aimeraient continuer mon application)</i></b>

- Utilisation de Firebase (notification push) </br>
- Bouton pour changer de vue passer d'une listView à une GridView </br>
- Rechercher un joueur ou une équipe avec une barre de recherche </br>
- Améliorer le design </br>
