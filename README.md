# TP3 – Serveur Multi‑threads en Java

##  Objectifs
- Comprendre et appliquer le principe d’un serveur multi‑threads basé sur les sockets TCP.
- Permettre la connexion simultanée de plusieurs clients.
- Améliorer le service calculatrice avec communication par objets et gestion d’accès concurrent.

---

##  Organisation des packages
- **`serverPackage`**
    - `Serveur.java` → serveur multi‑threads (Activité 3‑1).
    - `ClientTH.java` → thread côté serveur (Activité 3‑1).
    - `ServerMT.java` → serveur calculatrice multi‑threads (Activité 3‑2).
    - `Operation.java` → classe sérialisable représentant une opération (Activité 3‑2).

- **`clientPackage`**
    - `Client.java` → programme client simple (Activité 3‑1).
    - `ClientMT.java` → programme client calculatrice (Activité 3‑2).

---

##  Activité 3‑1 : Acceptation de plusieurs clients
### Étapes
1. Le serveur démarre et attend les connexions (`ServerSocket`).
2. À chaque connexion, il crée un thread `ClientTh` dédié.
3. Le thread envoie un message personnalisé au client (numéro d’ordre).
4. Le client lit et affiche le message reçu.

### Exemple d’exécution
- **Serveur** :
  ```
   Serveur en attente de connexions...
  Client n°1 connecté, adresse : /127.0.0.1:56789
  Dialogue avec client n°1
  ```
- **Client** :
  ```
   Connecté au serveur !
  Message reçu : Bienvenue, vous êtes le client n°1
  ```

---

##  Activité 3‑2 : Calculatrice multi‑threads
### Étapes
1. Le serveur démarre et attend les connexions.
2. Chaque client envoie une opération sous forme d’objet `Operation`.
3. Le serveur calcule le résultat et le renvoie.
4. Un compteur global synchronisé affiche le nombre total d’opérations traitées.

### Exemple d’exécution
- **Serveur** :
  ```
   Serveur calculatrice multi-threads démarré...
   Opérations traitées : 1
   Opérations traitées : 2
  ```
- **Client** :
  ```
  Donnez une opération (ex: 10 + 5) ou 'quit' : 10 + 5
  Résultat = 15
  ```

---




