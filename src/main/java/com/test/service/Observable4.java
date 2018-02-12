package com.test.service;

import com.test.IFun;

/**
 * 被观察者,在这里需要重点关注map()方法和lift()方法.
 */
public class Observable4<T> {
        protected OnAttach4 onAttach4;

        public Observable4(OnAttach4 onAttach) {
            this.onAttach4 = onAttach;
        }

        public static <T> Observable4<T> create(OnAttach4<T> onAttach4) {
            return new Observable4(onAttach4);
        }


        public void attach(IObserver4<T> observer) {
            onAttach4.call(observer);
        }

        public <R> Observable4<R> map(IFun<? super T, ? extends R> fun) {
            OperatorMap operatorMap = new OperatorMap(fun);
            //根据操作符生成新的Observable,并返回,以便实现链式操作
            Observable4 observable = lift(operatorMap);
            return observable;

        }

        public interface OnAttach4<T> {
            void call(IObserver4<? super T> observer);
        }

        //重点,该方法的实现了方法链.
        public <R> Observable4<R> lift(Operator<? extends R, ? super T> operator) {
            return new Observable4<>(new OnAttach4() {
                @Override
                public void call(IObserver4 observer) {
                    IObserver4<? super T> call = operator.call(observer);
                    Observable4.this.onAttach4.call(call);

                }
            });
        }

        //1.操作符接口
        public interface Operator<R, T> extends IFun<IObserver4<? super R>, IObserver4<? super T>> {}


}
