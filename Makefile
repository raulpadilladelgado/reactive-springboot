.SILENT:

MSG_SEPARATOR                     := "==================================================================================================="
MSG_IDENT                         := "    "
YELLOW            := \033[1;33m
LIGHT_RED         := \033[1;31m
NO_COLOUR         := \033[0m
PROJECT_DESCRIPTION        := Reactive application

DOCKER_COMPOSE_LOCAL       := -docker-compose -f docker/docker-compose.yml

help:
	echo "${MSG_SEPARATOR}"
	echo "\n${YELLOW}${MSG_IDENT}${PROJECT_DESCRIPTION}${NO_COLOUR}\n"
	echo "${MSG_IDENT}  ${LIGHT_RED}start${NO_COLOUR} -  🆙 Start the application and database"
	echo "${MSG_IDENT}  ${LIGHT_RED}stop${NO_COLOUR}  -  🛑 Stop the application and database"
	echo "${MSG_IDENT}  ${LIGHT_RED}logs${NO_COLOUR}  -  📃 View the logs"
	echo

start:
	./gradlew build -x test
	${DOCKER_COMPOSE_LOCAL} up -d --build
	echo "\n\n${MSG_SEPARATOR}\n\n  🐳 Your app is running 🚀\n"

stop:
	${DOCKER_COMPOSE_LOCAL} down --remove-orphans
	echo "\n${MSG_IDENT}✅ Done.\n"

logs:
	${DOCKER_COMPOSE_LOCAL} logs -f