package com.example.model;

public enum EnumMovies {
    AVENTURA {
        @Override
        public Integer valor() {
            return 1;
        }
    },
    SERIES {
        @Override
        public Integer valor() {return 2;}
    },
    INFANTILES{
        @Override
        public Integer valor() {return 3;}
    },
    PELICULAS{
        @Override
        public Integer valor() {return 4;}
    };
    public abstract Integer valor();
}
