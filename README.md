# PAOproject
Assignment for second term Java course
Project description

-site: "http://pao.neural-soft.com/"
-nume: "Imprimare online"
-descriere: "O firma se ocupa de imprimarea canilor, tricourilor sau a altor obiecte. Mult timp aceasta a functionat astaptand clientii sa vina la magazin cu un stick de memorie sau un card pe care aveau o poza si pe care doreau sa o puna pe un tricou sau pe o cana. Directorul magazinului a observat ca tot mai multi clienti ar dori sa trimita pe mail poza si sa vina doar sa ridice produsul cand acesta e gata. Realizati o aplicatie care sa permita clientilor sa trimita pe net poza si sa fie notificati cand produsul este gata."
-important: "Este permis doar implementare web"
-cerinte: 
    -Modul backend management clienti (blocare conturi, deblocare conturi)
    -Modul care sa permita clientilor creare cont, resetare parola
    -Modul backend adaugare lista servicii/produse si preturile aferente. Fiecare produs are asociat o lista de servicii la care poate fi selectat!
    -Clientul poate comanda un serviciu si un produs care se potriveste, si poate trimite o poza. De exemplu produsul "tricou alb" si serviciul "Inscriptionare color tricouri" si trimite o poza. Un client trebuie sa nu poata comanda "Tricou alb" si serviciul      "Inscriptionare cani", serverul dand un mesaj de eorare. Fiecare comanda are un ID unic
    -Modul cautare client dupa ID comanda pentru a il notifica ca produsul este gata. Acest modul va arata si toate comenzile clientului respectiv, astfel incat daca mai sunt si alte produse pe care clientul le asteapta sa stim sa nu il notificam
    -Modul raportare vanzari, pe produs, pe serviciu si pe client (Nota: dupa cum vedeti nu lucram cu date calendaristice, s-ar putea sa va fie mai usor daca le excludeti. Nu avem raporturi "pe luna" ci doar raporturi pe produs, serviciu, client)
