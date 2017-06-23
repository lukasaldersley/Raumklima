# Raumklima
Software für ein Arduino-basiertes Gerät zur Überwachung des Raumklimas.

Dieses Projekt wird/wurde durchgeführt im Rahmen eines W-Seminares von Lukas Aldersley am Josef-Effner-Gymnasium in Dachau.

Funktionsfähige Software befindet sich im Ordner Release (als .jar oder als .ino Datei)

Dieses Projekt soll sich in mehrere teile gliedern:
  - Den Code für den Arduino (vorraussichtlich ein Arduino MEGA2560 R3)
  - Das Layout für das Shield für den Arduino
  - Eine Auswertungssoftware für die aufgezeichneten Klimadaten (JAVA mit JFreeChart)
  - Eine Auswertungs App für die Universelle Windows Platform (UWP) (war nicht angefragt möchte ich aber persönlich haben; vermutlich nur für Live-daten und vorher Aufgezeichnete daten von der sd-karte, keine direkte aufzeichung in der App
  
Der Aktuelle entwicklungsstatus ist: 
  - Die Arduino-Software funktioniert, muss aber noch optimiert werden
  - Die Java Software ist funktionsfähig, muss aber noch optimiert werden
  - Die UWP App funktioniert noch nicht wirklich (erst diese Woche angefangen), BT-verbindung funktioniert prinnzipiell, in/outputstream verarbeitung nicht wie gewünscht
  
Noch zu tun ist:
  - das sekundäre LCD-Display (für Einstellungen) im Arduino Code wieder einfügen
  - UWP zum laufen Bringen
  - Viel Testen
  - Code Optimieren
  - Platine Optimieren und zum ätzen designen
