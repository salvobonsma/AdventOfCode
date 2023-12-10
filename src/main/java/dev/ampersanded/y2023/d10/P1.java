package dev.ampersanded.y2023.d10;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;
import dev.ampersanded.lib.Point;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        ArrayList<Pair<Pipe, Point>> pipes = new ArrayList<>();

        String[] lines = input.split("\n");
        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            for (int x = 0; x < line.split("").length; x++) {
                Pipe pipe = pipeFromString(line.split("")[x]);
                if (pipe.equals(Pipe.GROUND)) continue;

                pipes.add(Pair.of(pipe, new Point(x, y)));
            }
        }

        ArrayList<Pair<Pipe, Point>> pipesInLoop = new ArrayList<>();
        Pair<Pipe, Point> lastPipe = null;
        for (Pair<Pipe, Point> pipe : pipes) {
            if (pipe.getFirst().equals(Pipe.START)) {
                lastPipe = pipe;
                break;
            }
        }
        pipesInLoop.add(lastPipe);

        ArrayList<Pair<Pipe, Point>> pipePool = new ArrayList<>(pipes);
        for (int i = 0; i < pipes.size(); i++) {
            for (Pair<Pipe, Point> pipe : pipePool) {
                if (lastPipe == null) break;
                if (isConnected(lastPipe, pipe)) {
                    pipePool.remove(pipe);
                    pipesInLoop.add(pipe);
                    lastPipe = pipe;
                    break;
                }
            }
        }

        return pipesInLoop.size() / 2 + "";
    }

    private boolean isConnected(Pair<Pipe, Point> pipeA, Pair<Pipe, Point> pipeB) {
        if (!pipeA.getSecond().isOneAway(pipeB.getSecond())) return false;
        if (pipeA.getFirst().equals(Pipe.START)) {
            return isConnected(Pair.of(Pipe.HORIZONTAL, pipeA.getSecond()), pipeB) ||
                    isConnected(Pair.of(Pipe.VERTICAL, pipeA.getSecond()), pipeB);
        }
        return isDirectedToEachOther(Pair.of(pipeA.getFirst().connectionA, pipeA.getSecond()), Pair.of(pipeB.getFirst().connectionA, pipeB.getSecond())) ||
                isDirectedToEachOther(Pair.of(pipeA.getFirst().connectionB, pipeA.getSecond()), Pair.of(pipeB.getFirst().connectionB, pipeB.getSecond())) ||
                isDirectedToEachOther(Pair.of(pipeA.getFirst().connectionA, pipeA.getSecond()), Pair.of(pipeB.getFirst().connectionB, pipeB.getSecond())) ||
                isDirectedToEachOther(Pair.of(pipeA.getFirst().connectionB, pipeA.getSecond()), Pair.of(pipeB.getFirst().connectionA, pipeB.getSecond()));
    }

    private boolean isDirectedToEachOther(Pair<Direction, Point> pointA, Pair<Direction, Point> pointB) {
        Direction directionA = pointA.getFirst();
        Direction directionB = pointB.getFirst();

        if (!directionA.opposite().equals(directionB)) return false;

        return switch (directionA) {
            case NORTH -> pointA.getSecond().getY() - pointB.getSecond().getY() == 1;
            case SOUTH -> pointA.getSecond().getY() - pointB.getSecond().getY() == -1;
            case EAST -> pointA.getSecond().getX() - pointB.getSecond().getX() == -1;
            case WEST -> pointA.getSecond().getX() - pointB.getSecond().getX() == 1;
        };
    }

    private Pipe pipeFromString(String input) {
        return switch (input) {
            case "|" -> Pipe.VERTICAL;
            case "-" -> Pipe.HORIZONTAL;
            case "L" -> Pipe.NORTH_EAST;
            case "J" -> Pipe.NORTH_WEST;
            case "7" -> Pipe.SOUTH_WEST;
            case "F" -> Pipe.SOUTH_EAST;
            case "S" -> Pipe.START;
            case "." -> Pipe.GROUND;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    enum Pipe {
        VERTICAL(Direction.NORTH, Direction.SOUTH),
        HORIZONTAL(Direction.WEST, Direction.EAST),
        NORTH_EAST(Direction.NORTH, Direction.EAST), // L
        NORTH_WEST(Direction.NORTH, Direction.WEST), // J
        SOUTH_WEST(Direction.SOUTH, Direction.WEST), // 7
        SOUTH_EAST(Direction.SOUTH, Direction.EAST), // F
        START(null, null),
        GROUND(null, null);

        final Direction connectionA;
        final Direction connectionB;

        Pipe(Direction connectionA, Direction connectionB) {
            this.connectionA = connectionA;
            this.connectionB = connectionB;
        }
    }

    enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public Direction opposite() {
            return switch (this) {
                case NORTH -> SOUTH;
                case SOUTH -> NORTH;
                case EAST -> WEST;
                case WEST -> EAST;
            };
        }
    }
}
