package br.com.codenation.ciandt.errorcenter.models;

public enum Level {
    DEBUG(1),
    WARNING(2),
    ERROR(3);

    public Integer level;

    Level(Integer level) {
        this.level = level;
    }
}

