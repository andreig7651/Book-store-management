# tema-1-andreig7651(Gavriliu Andrei 323CB)

Clasa Book:-ne definim campurile corespunzator;campurile keyword si authors vor fi de tip liste,pe care le initializam folosind un constructor;
	   -definim metoda Publish,implementata de interfata IPublishingArtifact;

Clasa Author:-definim campurile sale corespunzatoare

Clasa Countries:-definim campurile corespunzatoare

Clasa EditorialGroup:-definim campurile;books va fi de tip lista,pe care o initializam cu un constructor;
                     -definim metoda Publish,implementata de interfata IPublishingArtifact;

Clasa Language:-definim campurile corespunzatoar

Clasa PublishingBrand:-definim campurile;books va fi de tip lista,pe care o initializam cu un constructor;
                      -definim metoda Publish,implementata de interfata IPublishingArtifact;

Clasa PublishingRetailer:-definim campurile;countries si publishingArtifacts vor fi de tip liste,initializate cu un constructor;

Interfata IPublishingArtifact:-interfata ce contine doar metoda Publish

Clasa Administration:-clasa in care definim lista de carti din sistem(books),lista de limbi(languages),cea de autori(authors),grupuri editoriale(groups),
                     branduri de publicare(brands),de retaileri(retailers),de tari(countries);
                     -totodata,definim si get-eri si set-eri pentru aceste liste,pentru a le transmite in main si invers;
                     -metodele addBook,addLanguage si addCountry,ce adauga un nou element intr-o lista,daca acesta nu exista deja in lista si intoarce lista
		             updatata
		     -metoda getBooksForPublishingRetailerID ce primeste un retailerID si intoarce lista de carti publicate de acest retailer;
                     	-initializam o lista goala,unde vom pune cartile gasite;
                     	-incepem sa iteram prin lista de retaileri si cautam retailer-ul dupa ID;
                     	-cand il gasim,incepem sa iteram prin artefactele sale;interpretam artefactul primit folosind instanceof;
                     	-daca e de tip Book,adaugam cartea in lista folosind addBook;
                     	-daca e de tip EditorialGroup,iteram prin lista de carti a grupului si adaugam toate cartile in lista;
		     	        -daca e de tip PublishingBrand,iteram prin lista de carti a brandului si adaugam toate cartile in lista;
		     	        -intoarcem lista de carti;
		    -metoda getLanguagesForPublishingRetailerID ce primeste un retailerID si intoarce o lista de tari in care au fost publicate cartile retailerului
			            -initializam o lista goala,unde vom pune limbile gasite;
                     	-incepem sa iteram prin lista de retaileri si cautam retailer-ul dupa ID;
                     	-cand il gasim,incepem sa iteram prin artefactele sale;interpretam artefactul primit folosind instanceof;
                     	-daca e de tip Book,iteram prin lista de limbi si cautam languageID(camp al Book);dupa ce il gasim,adaugam limba in lista;
                     	-daca e de tip EditorialGroup,iteram prin lista de carti a grupului,iar pentru fiecare carte,cautam limba corespunzatoare pe care o adaugam in lista;
		     	        -daca e de tip PublishingBrand,iteram prin lista de carti a brandului,iar pentru fiecare carte,cautam limba corespunzatoare pe care o adaugam in lista;
		     	        -intoarcem lista de limbi gasita;
		    -metoda getCountriesForBookID ce intoarce rile în care o carte a ajuns,primind un bookID            
                        -incepem sa parcurgem lista de retaileri si cautam cartea prin fiecare artefact al fiecarui retailer
                        -verificam fiecare artefact din retailer folosind instanceof;
                        -daca e de tip Book,adaugam toate tarile retailer-ului in lista de tari;
                        -daca e de tip EditorialGroup,parcurgem toate cartile grupului,cautand cartea dupa ID;
                        -daca o gasim,adaugam toate tarile retailer-ului in lista
                        -daca e de tip PublishingBrand,parcurgem toate cartile brandului,cautand cartea dupa ID;
                        -daca o gasim,adaugam toate tarile retailer-ului in lista;
                        -intoarcem lista de tari;
            -metoda getCommonBooksForRetailerIDs ce primeste ID-urile a 2 retailer si intoarce cartile lor comune;
                    	-initializam o lista in care vom pune cartile comune;
                        -folosind metoda deja descrisa getBooksForPublishingRetailerID,initializam 2 liste in care vom avea cartile corespunzatoare pentru fiecare retailer;
                        -iteram prin prima lista,iar in acelasi timp comparam fiecare carte cu fiecare carte din a doua lista;
                        -daca gasim carti cu acelasi ID,le adaugam in lista de carti comune;
                        -intoarcem lista de carti comune;
            -metoda getAllBooksForRetailerIDs ce intoarce reuniunea de carti a doi retaileri,primin ID-urile lor;
                        -initializam o lista in care vom pune toate cartile celor doi retaileri;
                        -folosind metoda deja descrisa getBooksForPublishingRetailerID,initializam 2 liste in care vom avea cartile corespunzatoare pentru fiecare retailer;
                        -reuniunea va fi initializata initial cu lista de carti a primului retailer;
                        -incepem sa parcurgem lista celui de al doilea;ne luam un contor ok=1;comparam toate cartile din a doua lista cu cele din prima;
                        -daca cartea din lista 2 se regaseste in prima,ok devine 0,deci nu o mai adaugam;
                        -dupa ce efectuam comparatia pentru o carte,verificam ok;daca el a ramas 1,adaugam cartea in lista;
                        -intoarcem lista de carti ceruta;

Clasa tema1:-clasa principala ce contine metoda main;
            -definim un element de tip Administration;initializam listele corespunzatoare folosind get-erele definite;
            -incepem sa citim din fiecare fisier si sa ne initializam listele;pentru fiecare lista definim un element de tipul corespunzator;
            ii completam campurile folosind un switch case,pentru a nu amesteca datele citite de pe linie;adaugam elementul in lista;updatam lista in Administration,folosind setter-ul;
	        -citim toate liniile din fisier,pana initializam toate datele;
            -apoi,conform datelor citite din fisiere,trebuie sa facem legaturile dintre clase;
            -books-authors.in:-inițializarea asocierilor dintre cărți și autori;
                              -salvam bookID si authorID in niste variabile,folosind switch;
                              -incepem sa parcurgem lista de carti si cautam cartea dupa ID;cand o gasim,facem acelasi lucru si pentru autor;
                              -cand gasim autorul,il adaugam in lista de autori a cartii;
	    -editorial-groups-books.in:-inițializarea asocierilor dintre grupuri de editare și autori;
                                   -salvam groupID si authorID in niste variabile,folosind switch;
                                   -incepem sa parcurgem lista de grupuri si cautam grupul;incepem sa parcurgem lista de carti si cautam ID-ul autorului,in fiecare lista de autori a fiecarei carti;cand gasim autorul,adaugam cartea corespunzatoare in lista de carti a grupului;
	    -publishing-brands-books.in:–inițializarea asocierilor dintre grupuri de publicare și autori;
				                    -salvam brandID si authorID in niste variabile,folosind switch;
                                    -iteram prin lista de brand-uri si cautam brand-ul dupa ID;
                                    -iteram prin lista de autori ai fiecarei carti si cautam autorul dupa ID;cand gasim autorul,adaugam cartea in lista de carti a brandului;
	    -publishing-retailers-countries.in:-inițializarea asocierilor dintre retailer și țări;
					         -salvam retailerID si countryID in niste variabile,folosind switch;
                             -iteram prin lista de retaileri si cautam retailer-ul dupa ID;cand il gasim,cautam tara identic
                             -adaugam tara in lista de tari a retailerului 
	    -publishing-retailers-books.in:-inițializarea asocierilor dintre retailer și cărți
                             -salvam retailerID si bookID in niste variabile,folosind switch;
                             -iteram prin lista de retaileri si cautam retailer-ul dupa ID;cand il gasim,cautam cartea identic
                             -adaugam cartea in lista de artefacte a retailerului;
	    -publishing-retailers-editorial-groups.in:-inițializarea asocierilor dintre retailer și grupuri de editare
						     -salvam retailerID si groupID in niste variabile,folosind switch;
                             -iteram prin lista de retaileri si cautam retailer-ul dupa ID;cand il gasim,cautam grupul identic
                             -adaugam grupul in lista de artefacte a retailerului;
	    -publishing-retailers-publishing-brands.in:-inițializarea asocierilor dintre retailer și grupuri de publicare
                                                   -salvam retailerID si brandID in niste variabile,folosind switch;
                                           	       -iteram prin lista de retaileri si cautam retailer-ul dupa ID;cand il gasim,cautam brandul identic
                                           	       -adaugam brandul in lista de artefacte a retailerului;

