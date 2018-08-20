schtasks /create /sc onstart /tn memcached /tr "'c:\memcached\memcached.exe' -m 512"
