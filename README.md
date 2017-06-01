# Raumklima
Software für ein Arduino-basiertes Gerät zur Überwachung des Raumklimas.

Dieses Projekt wird/wurde durchgeführt im Rahmen eines W-Seminares von Lukas Aldersley am Josef-Effner-Gymnasium in Dachau.

Dieses Projekt soll sich in mehrere teile gliedern:
  - Den Code für den Arduino (vorraussichtlich ein Arduino MEGA2560 R3)
  - Das Layout für das Shield für den Arduino
  - Eine Auswertungssoftware für die aufgezeichneten Klimadaten (JAVA mit JFreeChart)
  - Eine Auswertungs App für die Universelle Windows Platform (UWP) (war nicht angefragt möchte ich aber persönlich haben; vermutlich nur für Live-daten und vorher Aufgezeichnete daten von der sd-karte, keine direkte aufzeichung in der App
  
Der Aktuelle entwicklungsstatus ist: 
  - Die Arduino-Software funktioniert (ohne LCD-Ausgabe; wurde zum debuggen entfernt)
  - Die Java Software kann die aufgezeichneten Daten Zeichnen, die von Herr Sonnauer Angefragte Funktionalität mit den Crosshairs       funktioniert nur mit einem datensatz, wie es mit mehreren funktioniert habe ich noch nicht herausgefunden.
  - Die UWP App funktioniert noch nicht wirklich (erst diese Woche angefangen), ich glaube dass die BT-Verbindung schon steht, bin mir aber nicht sicher
  
Noch zu tun ist:
  - Die beiden LCD-Displays im Arduino Code wieder einfügen
  - UWP zum laufen Bringen
  - Java JFreeChart verstehen
  - Java Crosshairs zum laufen bringen
  - Viel Testen
  - Code Optimieren
