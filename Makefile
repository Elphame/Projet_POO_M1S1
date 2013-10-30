# author: Antoine Lafouasse

NAME  = Projet.jar
OBJS  = Main Util
OBJS += Carte Deck Couleurs Valeurs
OBJS += Jeu FortyAndEight
ENPT  = Main

.PHONY: all clean fclean re
.SUFFIXES:

all: $(NAME)

$(NAME): $(addsuffix .class, $(OBJS))
	echo "Main-Class:" $(ENPT) > MANIFEST.MF
	jar cvmf MANIFEST.MF $(NAME) $(addsuffix .class, $(OBJS))

%.class: %.java
	javac $<

clean:
	rm -rf $(addsuffix .class, $(OBJS))
	rm -rf MANIFEST.MF

fclean: clean
	rm -rf $(NAME)

re: fclean all
