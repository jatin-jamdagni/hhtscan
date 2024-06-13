import {NativeModules} from 'react-native';
const {UhfModule} = NativeModules;

export const initUHF = callback => {
  UhfModule.initUHF(callback);
};

export const setScanMode = (mode, callback) => {
  UhfModule.setScanMode(mode, callback);
};

export const startScan = callback => {
  UhfModule.startScan(callback);
};

export const stopScan = callback => {
  UhfModule.stopScan(callback);
};
