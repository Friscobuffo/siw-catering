# siw-catering
Caso d’uso UC1: Iscrizione nuovo utente
    Un nuovo utente vuole iscriversi al sistema
    Il nuovo utente clicca su Discover
    Il nuovo utente clicca su Crea un account
    Il nuovo utente inserisce username, password, nome, cognome, email
    Il nuovo utente clicca su Registra
    Il Sistema registra il nuovo utente e gli assegna un codice identificativo univoco.
    Il Sistema mostra una pagina di conferma della registrazione

Caso d’uso UC2: Login utente
    Un utente vuole effettuare il login al sistema
    L'utente clicca su Discover
    L'utente inserisce username, password
    L'utente clicca su Login
    Il Sistema mostra la pagina home per gli utenti

Caso d’uso UC3: Login amministratore
    Un amministratore vuole effettuare il login al sistema
    L'amministratore clicca su Discover
    L'amministratore inserisce username, password
    L'amministratore clicca su Login
    Il Sistema mostra la pagina home specifica per l'amministrazione

Caso d’uso UC4: Naviga buffet - Attore primario: un utente loggato
    Un utente ha fatto l'accesso al sistema e vuole navigare i buffet offerti dalla società
    L’utente seleziona l’operazione “Lista buffet”
    Il sistema mostra l’elenco dei buffet
    L’utente seleziona il buffet del quale vuole visionare i dettagli
    Il sistema mostra le informazioni del buffet, e i piatti che lo riguardano

Caso d’uso UC5: Naviga chef - Attore primario: un utente loggato
    Un utente ha fatto l'accesso al sistema e vuole navigare gli chef dalle società
    L’utente seleziona l’operazione “Lista buffet”
    il sistema mostra l’elenco dei buffet
    l’utente seleziona lo chef del quale vuole visionare i dettagli
    il sistema mostra le informazioni dello chef, e i buffet offerti dallo stesso

Caso d’uso UC6: Inserimento nuovo Chef - Attore primario: un Amministratore
    Un Amministratore vuole inserire un nuovo Chef
    L’Amministratore effettua il login
    L’Amministratore seleziona l’operazione “aggiungi chef”
    L’Amministratore inserisce nome, cognome e nazionalità dello Chef
    L’Amministratore conferma l’inserimento
    Il Sistema salva lo Chef e tutte le sue informazioni nel Sistema, e gil assegna un codice identificativo univoco
    Il Sistema mostra l'elenco degli chef

Caso d’uso UC7: Modifica Chef - Attore primario: un Amministratore
    Un Amministratore vuole modificare uno chef
    L’Amministratore effettua il login
    L’amministratore seleziona l’operazione “lista chef”
    Il sistema mostra gli chef della società
    L’Amministratore sceglie lo che vuole modificare e clicca su "modifica"
    Il Sistema mostra le informazioni dello chef
    L’Amministratore effettua le modifiche
    L’amministratore conferma le modifiche
    Il Sistema salva le modifiche
    Il sistema mostra l'elenco degli chef

Caso d’uso UC8: Inserimento nuovo Buffet - Attore primario: un Amministratore
    Un Amministratore vuole inserire un nuovo Buffet
    L’Amministratore effettua il login
    L’Amministratore seleziona l’operazione “lista chef”
    Il Sistema mostra gli Chef del Sistema
    L’Amministratore seleziona "aggiungi buffet" sullo Chef che propone il nuovo Buffet
    L’Amministratore inserisce il nome del buffet e una descrizione testuale.
    L’Amministratore conferma l’inserimento
    Il Sistema registra tutte le informazioni sul nuovo buffet, e gli assegna un codice identificativo univoco.
    Il sistema mostra tutte le informazioni dello chef e i suoi buffet

Caso d’uso UC9: Inserimento nuovo Ingrediente - Attore primario: un Amministratore
    Un Amministratore vuole inserire un nuovo ingrediente
    L’Amministratore effettua il login
    L’Amministratore seleziona l’operazione “aggiungi ingrediente”
    L’Amministratore inserisce il nome dell'ingrediente, una descrizione testuale e l'origine.
    L’Amministratore conferma l’inserimento
    Il Sistema registra tutte le informazioni sul nuovo ingrediente, e gli assegna un codice identificativo univoco.
    Il sistema mostra l'elenco degli ingredienti

Caso d’uso UC10: Aggiungere Ingrediente a un piatto - Attore primario: un Amministratore
    Un Amministratore vuole aggiungere un ingrediente a un piatto di un buffet offerto da uno chef
    L’Amministratore effettua il login
    L’Amministratore seleziona l’operazione “lista chef”
    L'amministratore clicca su "modifica" sullo chef che offre il buffet
    Il sistema mostra l'elenco dei piatti del buffet
    L'amministratore clicca su "modifica" sul piatto
    L'amministratore clicca su "aggiungi ingrediente"
    L'amministratore cerca l'ingrediente dato il nome
    Il sistema mostra gli ingredienti risultati dalla ricerca
    L'amministratore clicca su aggiungi, dell'ingrediente da aggiungere
    Il Sistema aggiunge l'ingrediente al piatto
    Il sistema mostra l'elenco degli ingredienti del piatto