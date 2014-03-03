package org.tlpl.statemachine;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractEqualsHashCodeTest<T> {

    protected abstract T getObject();

    protected abstract T getEqualObject();

    protected abstract T getAnotherEqualObject();

    protected abstract T getDifferentObject();

    protected T getObjectWithNullParameterContructor() {
        return getDifferentObject();
    }

    protected T getAnotherObjectWithNullParameterContructor() {
        return getDifferentObject();
    }

    @Test
    public void equals_reflexive_isEqual() {
        T object = getObject();
        Assert.assertTrue(object.equals(object));
        Assert.assertEquals(object.hashCode(), object.hashCode());
    }

    @Test
    public void equals_symmetric_isEqual() {
        Assert.assertTrue(getEqualObject().equals(getObject()));
        Assert.assertEquals(getEqualObject().hashCode(), getObject().hashCode());
        Assert.assertTrue(getObject().equals(getEqualObject()));
        Assert.assertEquals(getObject().hashCode(), getEqualObject().hashCode());
    }

    @Test
    public void equals_transitiv_isEqual() {
        Assert.assertTrue(getObject().equals(getEqualObject()));
        Assert.assertEquals(getObject().hashCode(), getEqualObject().hashCode());
        Assert.assertTrue(getEqualObject().equals(getAnotherEqualObject()));
        Assert.assertEquals(getEqualObject().hashCode(), getAnotherEqualObject().hashCode());
        Assert.assertTrue(getObject().equals(getAnotherEqualObject()));
        Assert.assertEquals(getObject().hashCode(), getAnotherEqualObject().hashCode());
    }

    @Test
    public void equals_null_isNotEqual() {
        Assert.assertFalse(getObject().equals(null));
    }

    @Test
    public void equals_differentObject_isNotEqual() {
        Assert.assertFalse(getObject().equals(getDifferentObject()));
        Assert.assertFalse(getObject().hashCode() == getDifferentObject().hashCode());
    }

    @Test
    public void equals_equalObject_newObject_isNotEqual() {
        Object object = new Object();
        Assert.assertFalse(getObject().equals(object));
        Assert.assertFalse(getObject().hashCode() == object.hashCode());
    }

    @Test
    public void equals_differentObject_nullParameterConstructor_isNotEqual() {
        Assert.assertFalse(getObject().equals(getObjectWithNullParameterContructor()));
        Assert.assertFalse(getObject().hashCode() == getObjectWithNullParameterContructor()
                .hashCode());
        Assert.assertFalse(getObjectWithNullParameterContructor().equals(getObject()));
        Assert.assertFalse(getObjectWithNullParameterContructor().hashCode() == getObject()
                .hashCode());
    }

    @Test
    public void equals_sameNullParameterConstrutor_isEqual() {
        Assert.assertTrue(getObjectWithNullParameterContructor().equals(
            getAnotherObjectWithNullParameterContructor()));
        Assert
                .assertTrue(getObjectWithNullParameterContructor().hashCode() == getAnotherObjectWithNullParameterContructor()
                        .hashCode());
    }

    @Test
    public void equals_consistent_NoError() {
        equals_reflexive_isEqual();
        equals_symmetric_isEqual();
        equals_transitiv_isEqual();
        equals_differentObject_isNotEqual();
        equals_null_isNotEqual();
    }

}
