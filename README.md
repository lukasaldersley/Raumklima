# Raumklima
Software für ein Arduino-basiertes Gerät zur Überwachung des Raumklimas.

Dieses Projekt wird/wurde durchgeführt im Rahmen eines W-Seminares von Lukas Aldersley am Josef-Effner-Gymnasium in Dachau.

Die Aktuelle Version ist 1.6.1.0
Die Software wird alle Updates automatisch installieren.

Funktionsfähige Software befindet sich im Ordner PublicVersion (als .jar oder als .ino Datei. Die VERSION datei wird nur vom updater gebraucht. Unter Umständen ist diese Software noch mit Bugs behaftet)
Natürlich ist die Software unter Releases (der Tab in der Navigation) auch lauffähig und fertiggestellt (nicht unbedingt auf dem allerneuesten stand, dafür aber einigermaßen stabil).

Dieses Projekt soll sich in mehrere teile gliedern:
  - Den Code für den Arduino (vorraussichtlich ein Arduino MEGA2560 R3)
  - Das Layout für das Shield für den Arduino
  - Eine Auswertungssoftware für die aufgezeichneten Klimadaten (JAVA mit JFreeChart)
  
Der Aktuelle entwicklungsstatus ist: 
  - Die Arduino-Software funktioniert, muss aber noch optimiert werden
  - Die Java Software ist fertig, zusätzliche Features werden aber noch hinzugefügt

  
Noch zu tun ist:
  - Viel Testen
  - Code Optimieren
  - Platine Optimieren und zum ätzen designen
  - Arduino Niederschlagssensor fertigmachen und in code implementieren
