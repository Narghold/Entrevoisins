# <img src="./app/src/main/ic_launcher-web.png" width="100" /> Entrevoisins

Application réalisée par **Dubois Yann** dans le cadre de la formation Développeur Android d'**OpenClassrooms**.

------

**Entrevoisins** est une application qui permet à des personnes d’un même quartier de se rendre des petits services : garde d’animaux, petit bricolage, troc d’objets, cours particuliers, de nombreuses options s’offrent aux utilisateurs !

------

<u>**Comment compiler et exécuter :**</u>

**Télécharger ou cloner** le repository depuis le [lien](https://github.com/Narghold/Entrevoisins).

Ouvrir le projet avec **Android Studio**.

Le Gradle s'exécute automatiquement, il ne vous reste plus qu'à lancer le projet sur équipement réel ou sur émulateur. Pour plus d'informations, rendez vous sur [la documentation officielle Android](https://developer.android.com/studio/run?hl=en).

------

**<u>Paramètres Lint :</u>**

La configuration **Lint** se trouve dans *build.gradle*.

```
lintOptions {
    abortOnError true
    checkAllWarnings true
    warningsAsErrors true
    disable 'AllowBackup', 'ContentDescription', 'InvalidPackage', 'SelectableText', 'SpUsage'
}
```

Vous pouvez également supprimer les **alertes Lint** en utilisant l'annotation *@SuppressLint()*. Voir http://tools.android.com/tips/lint/suppressing-lint-warnings pour plus de détails.

Les résultats **Lint** sont visibles à ./build/lint-results.html.

------

**<u>Détails :</u>**

Pour plus de détails sur ce projet, je vous invite à visiter la **page OpenClassrooms** du projet à [ce lien](https://openclassrooms.com/fr/projects/605/assignment).
