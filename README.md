# Raumklima
Software für ein Arduino-basiertes Gerät zur Überwachung des Raumklimas.

Dieses Projekt wird/wurde durchgeführt im Rahmen eines W-Seminares von Lukas Aldersley am Josef-Effner-Gymnasium in Dachau.

Die Aktuelle Version ist 1.0.
Die Software wird alle Updates automatisch installieren.

Funktionsfähige Software befindet sich im Ordner Release (als .jar oder als .ino Datei. Die VERSION datei wird nur vom updater gebraucht. Unter Umständen ist diese Software noch mit Bugs behaftet)
Natürlich ist die Software unter Releases (der Tab in der Navigation) auch lauffähig und fertiggestellt.

Dieses Projekt soll sich in mehrere teile gliedern:
  - Den Code für den Arduino (vorraussichtlich ein Arduino MEGA2560 R3)
  - Das Layout für das Shield für den Arduino
  - Eine Auswertungssoftware für die aufgezeichneten Klimadaten (JAVA mit JFreeChart)
  - Eine Auswertungs App für die Universelle Windows Platform (UWP) (war nicht angefragt möchte ich aber persönlich haben; vermutlich nur für Live-daten und vorher Aufgezeichnete daten von der sd-karte, keine direkte aufzeichung in der App
  
Der Aktuelle entwicklungsstatus ist: 
  - Die Arduino-Software funktioniert, muss aber noch optimiert werden
  - Die Java Software ist fertig, zusätzliche Features werden aber noch hinzugefügt
  - Die UWP App funktioniert noch nicht wirklich (erst diese Woche angefangen), BT-verbindung funktioniert prinnzipiell, in/outputstream verarbeitung nicht wie gewünscht
  
Noch zu tun ist:
  - UWP zum laufen Bringen
  - Viel Testen
  - Code Optimieren
  - Platine Optimieren und zum ätzen designen
