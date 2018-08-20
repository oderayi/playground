<?php

class Server {

    var $heroes = [];

    function __construct() {
        $this->heroes = [
            new Hero(11, 'Mr. Nice'),
            new Hero(12, 'Narco'),
            new Hero(13, 'Bombasto'),
            new Hero(14, 'Celeritas'),
            new Hero(15, 'Magneta'),
            new Hero(16, 'RubberMan'),
            new Hero(17, 'Dyana'),
            new Hero(18, 'Dr. IQ'),
            new Hero(19, 'Magma'),
            new Hero(20, 'Tornado'),
        ];
    }

    function index() {
        $this->sendDefaultHeaders();
        $data = new stdClass();
        $data->data = $this->heroes;
        echo json_encode($this->wrapData($this->heroes));

    }

    function get() {
        $id = $_GET['id'];
        $this->sendDefaultHeaders();
        $data = null;
        foreach ($this->heroes as $hero) {
           if ($hero->id == $id) {
               $data = $hero;
               break;
           }
        }
        echo json_encode($this->wrapData($data));

    }

    function store() {
        $input = $_POST;
        $newHero = new Hero();
        $newHero->id = shuffle(range(21, 100))[0];
        $newHero->name = $input['name'];
        $this->heroes[] = $newHero;
        error_log("Added new Hero {$newHero->name}: " + var_export($this->heroes, true));
    }

    function update() {

    }

    private function sendDefaultHeaders() {
        header("Access-Control-Allow-Origin: *"); // Enable CORS.
        header("Content-type: application/json");
    }

    private function wrapData($data){
        $wrapper = new stdClass();
        $wrapper->data = $data;
        return $wrapper;
    }

}

class Hero {
    public $id;
    public $name;

    function __construct($id, $name) {
        $this->id = $id;
        $this->name = $name;
    }
}

$server = new Server();
$action = @$_GET['action'];
$server->$action();
