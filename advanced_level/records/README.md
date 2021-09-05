# Records
Начиная с версии Java 16 в язык была добавлена новая функциональность - Records (на русском нередко называют "записями"). Records представляют классы, которые предназначены для создания контейнеров неизменяемых данных. Кроме того, records позволяют упростить разработку, сократив объем кода.

Для определения классов record применяется ключевое слово record, после которого идет название и далее в круглых скобках список полей record:

	record название (поле1, поле2,...полеN){
	    // тело record
	}