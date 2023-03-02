package config;

import handler.Handler;
import handler.Mapper;
import inputreader.CmdInputReader;
import inputreader.InputReader;
import shape.*;
import validation.*;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private static Configuration instance;
    private final Handler handler;
    private final Mapper mapper;
    private final InputReader inputReader ;

    private final Map<ShapeType, Shape> shapeMap;
    private final Map<ShapeType, Validator> validatorMap;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    private Configuration() {
        mapper = new Mapper();
        inputReader = new CmdInputReader();
        shapeMap = createShapeMap();
        validatorMap = createValidatorMap();
        handler = new Handler(shapeMap, validatorMap);
    }

    private Map<ShapeType, Shape> createShapeMap() {
        Map<ShapeType, Shape> shapeMap = new HashMap<>();
        shapeMap.put(ShapeType.CANVAS, new Canvas());
        shapeMap.put(ShapeType.LINE, new Line());
        shapeMap.put(ShapeType.RECTANGLE, new Rectangle());
        shapeMap.put(ShapeType.BUCKET, new Bucket());
        return shapeMap;
    }

    private Map<ShapeType, Validator> createValidatorMap() {
        Map<ShapeType, Validator> validatorMap = new HashMap<>();
        validatorMap.put(ShapeType.CANVAS, new CanvasValidator());
        validatorMap.put(ShapeType.LINE, new LineValidator());
        validatorMap.put(ShapeType.RECTANGLE, new RectangleValidator());
        validatorMap.put(ShapeType.BUCKET, new BucketValidator());
        return validatorMap;
    }

    public Handler getHandler() {
        return handler;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public Map<ShapeType, Shape> getShapeMap() {
        return shapeMap;
    }
    public Map<ShapeType, Validator> getValidatorMap() {
        return validatorMap;
    }
}
